    // Downloading file using OkHttp & Okio

    private lateinit var client: OkHttpClient

    fun dowloadFile(url: String) {
        val httpUrl = HttpUrl.parse(url)!!
        val fileName = httpUrl.encodedPathSegments().last() ?: "file"
        val response = client.newCall(Request.Builder().get().url(url).build()).execute()
        val source = response.body()?.source()
        val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName)
        if (file.createNewFile()) {
            val buffer = file.sink().buffer()
            source?.use { input ->
                buffer.use { output ->
                    output.writeAll(input)
                }
            }
        }
    }