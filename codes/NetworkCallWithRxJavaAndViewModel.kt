/* Sample network call with using RxJava, ViewModel and LiveData
First of all prepare your Resource.kt and Status.kt classes*/

class Resource<T> constructor(val status: Status, val data: T?, val error: Throwable? = null) {

    companion object {

        fun <T> success(@NonNull data: T): Resource<T> {
            return Resource(Status.SUCCESS, data)
        }

        fun <T> error(throwable: Throwable): Resource<T> {
            return Resource(status = Status.ERROR, data = null, error = throwable)
        }

        fun <T> loading(): Resource<T> = Resource(Status.LOADING, null)
    }
}

enum class Status {
    SUCCESS,
    LOADING,
    ERROR
}

// We'll handle our reponse status with this classes.

// How to use?
class HomeViewModel(app: Application) : BaseViewModel(app) {

    private val disposable = CompositeDisposable()
    val bestPodcastsLiveData = MutableLiveData<Resource<BestPodcasts>>()

    fun getBestPodcasts(region: String, explicitContent: Int) {
        disposable.add(baseApi.getBestPodcasts(region, explicitContent)
                .subscribeOn(Schedulers.io())
                .map { Resource.success(it) } // Map your data to your Resource class
                .onErrorReturn { Resource.error(it) } // When an error occured map it to your Resource class
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    when (it?.status) {
                        Status.SUCCESS -> bestPodcastsLiveData.postValue(it)
                    // Post your response to livedata
                        Status.LOADING -> Log.v("BestPodcasts", "Loading")
                    // Loading state
                        Status.ERROR -> Log.v("BestPodcasts", "${it.error?.printStackTrace()}")
                    // Uh-oh! An error occured.
                    }
                })
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear() // Don't need disposable any more.
    }
}

// Now you are able to use your data in UI.
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(HomeViewModel::class.java) {

    override fun init() {
        initBestPodcasts()
    }

    private fun initBestPodcasts() {

        viewModel.getBestPodcasts(viewModel.currentLocation, 0)

        viewModel.bestPodcastsLiveData.observe(this@HomeFragment, Observer<Resource<BestPodcasts>> {
            (mBinding.recyclerViewBestPodcasts.adapter as BestPodcastsAdapter).submitList(it.data?.channels)
        })
    }
}
