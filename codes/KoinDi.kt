//App.kt
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        loadKoin()
    }

    private fun loadKoin() {
        startKoin(
                this, listOf(
                viewModelModules,
               ...
            )
        )
    }
}

//AppModule.kt
val viewModelModules = module {
    viewModel {
        MoviesViewModel(getMoviesUseCase = get(GET_MOVIES_USECASE), mapper = MoviesEntityMapper())
    }
}

//MoviesViewModel.kt
class MoviesViewModel(
        private val getMoviesUseCase: GetMoviesUseCase,
        private val mapper: Mapper<MoviesEntity, Movies>
) : BaseViewModel() {

    var mMovies = MutableLiveData<Data<Movies>>()

    fun fetchMovies(
            mediaType: String,
            timeWindow: String
    ) {
        val disposable = getMoviesUseCase.getMovies(mediaType, timeWindow)
                .flatMap { mapper.Flowable(it) }
                .subscribe({ response ->
                    Log.d(TAG, "On next Called")
                    mMovies.value = Data(
                            responseType = Status.SUCCESSFUL,
                            data = response
                    )
                }, { error ->
                    Log.d(TAG, "On error Called")
                    mMovies.value = Data(
                            responseType = Status.ERROR,
                            error = Error(error.message)
                    )
                }, {
                    Log.d(TAG, "On complete Called")
                })
        addDisposable(disposable)
    }

    fun getMoviesLiveData() = mMovies

    companion object {
        private val TAG = "view_model"
    }
}

//MoviesEntityMapper.kt
class MoviesEntityMapper : Mapper<MoviesEntity, Movies>() {

    override fun mapFrom(from: MoviesEntity): Movies = Movies(
            page = from.page,
            results = mapListMoviesToPresentation(from.results)
    )

    private fun mapListMoviesToPresentation(movies: List<MoviesItemEntity>?):
            List<MoviesItem> = movies?.map { mapMoviesToPresentation(it) } ?: emptyList()

    private fun mapMoviesToPresentation(response: MoviesItemEntity): MoviesItem = MoviesItem(
            vote_count = response.vote_count,
            vote_average = response.vote_average,
            title = response.title,
            release_date = response.release_date,
            poster_path = response.poster_path
    )
}

//Const val
private const val GET_MOVIES_USECASE = "getMoviesUseCase"
