import com.google.gson.annotations.SerializedName

class Repo {
    var id: Int? = null
    var name: String? = null
    @SerializedName("full_name")
    var repoFullName: String? = null

}