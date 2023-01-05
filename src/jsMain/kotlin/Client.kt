import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import react.create
import react.dom.client.createRoot
import web.dom.document

fun main() {
  val container = document.createElement("div")
  document.body!!.appendChild(container)

  val welcome = Welcome.create {
    name = "Kotlin/JS"
  }
  createRoot(container).render(welcome)
}