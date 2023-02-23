import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ansh.practise.AnimeQuoteModel
import com.ansh.practise.AnimeQuoteRepository
import kotlinx.coroutines.Dispatchers
import com.ansh.practise.ApiInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuotesViewModel() : ViewModel() {
    val animeQuote = MutableLiveData<AnimeQuoteModel>()

    val loading = MutableLiveData<Boolean>()


    fun loadData(){
        val repo = AnimeQuoteRepository()
        CoroutineScope(Dispatchers.IO).launch {
            val data = repo.getAnimeQuote()
            withContext(Dispatchers.Main) {
                if (data!=null) {
                    animeQuote.postValue(data)
                    loading.value = false
                    Log.d("mssg",data.toString())
                } else {
                    Log.e("quote-error","NULL QUOTE")
                }

            }
        }

    }

}