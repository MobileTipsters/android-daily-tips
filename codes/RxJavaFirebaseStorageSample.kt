/*
* Get images from firebase only whose names are known
*/

class ProductDetailFragment : BaseFragment<ProductDetailViewModel, FragmentProductDetailBinding>(ProductDetailViewModel::class.java) {
    /*
    * some stuff
    */
    val images: List<String>? = productEntity.getImageList()
    // images = ["sample1.png","sample2.png"]

    disposable.add(
    viewModel.getFullImagePaths(it).subscribe { slides ->
        // slides = arraylist of full image paths from Firebase Storage.
        // Sample1.png : https://firebasestorage.googleapis.com/v0/b/yourapp-android.appspot.com/o/sample1.png?
        // alt=media&token=3ba40117-19ec-4be1-8621-ca23da8f46bc
    })
}

class ProductDetailViewModel(app: Application) : BaseViewModel(app) {

    val storage = FirebaseStorage.getInstance()
    val storageRef = storage.reference

    init {
        (app as App).component.inject(this)
    }

    private fun getFullImagePathFromFirebase(imageName: String): Single<String> {
        return Single.create { single ->
            storageRef.child(imageName).downloadUrl
                    .addOnSuccessListener {
                        single.onSuccess(it.toString())
                    }.addOnFailureListener {
                        single.onSuccess("")
                        Log.d("FirebaseImages", "Child name not found.")
                    }
        }
    }

    fun getFullImagePaths(imageList: List<String>): Observable<List<String>> {
        return Observable
                .fromIterable(imageList)
                .flatMap { getFullImagePathFromFirebase(it).toObservable() }
                .toList()
                .toObservable()
    }
}