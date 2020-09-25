import com.google.gson.annotations.SerializedName


data class Series (

	@SerializedName("available") val available : String,
	@SerializedName("returned") val returned : String,
	@SerializedName("collectionURI") val collectionURI : String,
	@SerializedName("items") val items : List<Items>
)