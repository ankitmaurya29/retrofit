
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun main(args: Array<String>) {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(GitHubService::class.java)
    val repos: Call<List<Repo?>?>? = service.listRepos("ankitmaurya29")

    repos?.enqueue(object: Callback<List<Repo?>?>{
        override fun onResponse(call: Call<List<Repo?>?>, response: Response<List<Repo?>?>) {
            response.body()?.forEach {
                println("${it?.id}, ${it?.repoFullName} , ${it?.name}")
            }
            println("new reposonse")
        }

        override fun onFailure(call: Call<List<Repo?>?>, t: Throwable) {

        }


    })
}