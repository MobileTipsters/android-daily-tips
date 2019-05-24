//To avoid illegal state exception you can use new launchWhenStarted method
class MyFragment: Fragment {
    init {
	// We are safely launch in the Fragment constructor
	// even if Lifecycle will be CREATED at first

        lifecycleScope.launchWhenStarted {
	    // This will suspend when state is < STARTED

	    // Here, since we've checked, it is safe to run any
            // Fragment transactions.
	    fragmentManager.beginTransaction()
        }
    }
}
//original article: http://bit.ly/2JDlKRs