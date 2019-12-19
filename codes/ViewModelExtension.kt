
//Extension functions for View Model Providers
inline fun <reified T : ViewModel> Fragment.viewModel(factory: Factory, body: T.() -> Unit): T {
    val vm = ViewModelProviders.of(this, factory)[T::class.java]
    vm.body()
    return vm
}


//Movies Fragment
moviesViewModel = viewModel(viewModelFactory) {
    observe(movies, ::getList)
    failure(failure, ::handleFailure)
}