class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>(SearchViewModel::class.java) {

    /*
    some stuff
    */

    // Wrong usage
    if (viewModel.genresLiveData.hasActiveObservers())
    viewModel.genresLiveData.removeObservers(this)

    viewModel.genresLiveData.observe(
    this@SearchFragment,
    Observer<Resource<Genres>> {
        it.data?.let { genres -> addChipToGroup(mBinding.chipGroupGenres, genres) }
    }
    )

    // Correct usage
    viewModel.genresLiveData.observe(viewLifecycleOwner,
    Observer<Resource<Genres>> {
        it.data?.let { genres -> addChipToGroup(mBinding.chipGroupGenres, genres) }})
}