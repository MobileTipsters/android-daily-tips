val purchasingApi: PurcahasingApi by lazy {
    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    retrofit.create(PurcahasingApi::class.java)
}