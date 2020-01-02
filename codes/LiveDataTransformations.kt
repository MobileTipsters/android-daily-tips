// Transformations switchMap and map LiveData-KTX usage

/* These methods permit functional composition and delegation of LiveData instances. The transformations are calculated
 * lazily, and will run only when the returned LiveData is observed. Lifecycle behavior is propagated from the input
 * source LiveData to the returned one. - more info.: developer.android.com/reference/androidx/lifecycle/Transformations
 */

class DashboardFragmentViewModel @Inject internal constructor(private val currentWeatherUseCase: CurrentWeatherUseCase) : BaseViewModel() {

    private val _currentWeatherParams: MutableLiveData<CurrentWeatherUseCase.CurrentWeatherParams> = MutableLiveData()
    fun getCurrentWeatherViewState() = currentWeatherViewState

    private val currentWeatherViewState: LiveData<CurrentWeatherViewState> = _currentWeatherParams.switchMap { params ->
        currentWeatherUseCase.execute(params) // When _currentWeatherParams triggered `switchMap` returns useCase.execute()
    }

    fun setCurrentWeatherParams(params: CurrentWeatherUseCase.CurrentWeatherParams) {
        if (_currentWeatherParams.value == params)
            return
        _currentWeatherParams.postValue(params)
    }
}


class CurrentWeatherUseCase @Inject internal constructor(private val repository: CurrentWeatherRepository) : UseCaseLiveData<CurrentWeatherViewState, CurrentWeatherUseCase.CurrentWeatherParams, CurrentWeatherRepository>() {

    override fun buildUseCaseObservable(params: CurrentWeatherParams?): LiveData<CurrentWeatherViewState> {
        return repository.loadCurrentWeatherByGeoCords(
                params?.lat?.toDouble() ?: 0.0,
                params?.lon?.toDouble() ?: 0.0,
                params?.fetchRequired
                        ?: false,
                units = params?.units ?: Constants.Coords.METRIC
        ).map { // When loadCurrentWeatherByGeoCords triggered `map` returns onCurrentWeatherResultReady()
            onCurrentWeatherResultReady(it)
        }
    }

    private fun onCurrentWeatherResultReady(resource: Resource<CurrentWeatherEntity>): CurrentWeatherViewState {
        return CurrentWeatherViewState(
                status = resource.status,
                error = resource.message,
                data = resource.data
        )
    }
}