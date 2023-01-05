import csstype.px
import csstype.rgb
import react.FC
import react.Props
import emotion.react.css
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import react.dom.html.InputType
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.useState

external interface WelcomeProps : Props {
  var name: String
}

val Welcome = FC<WelcomeProps> { props ->
  val supabase = createSupabaseClient(
    TODO(),
    TODO()
  ) {
    install(GoTrue)
  }

  var name by useState(props.name)
  div {
    css {
      padding = 5.px
      backgroundColor = rgb(8, 97, 22)
      color = rgb(56, 246, 137)
    }
    +"Hello, $name"
  }
  input {
    css {
      marginTop = 5.px
      marginBottom = 5.px
      fontSize = 14.px
    }
    type = InputType.text
    value = name
    onChange = { event ->
      name = event.target.value
    }
  }

  button {
    onClick = {

      GlobalScope.launch {
        supabase.gotrue.signUpWith(Email) {
          email = "test@test.com"
          password = "password"
        }
      }
    }

    +"Sign Up"
  }
}