
/**
  *Creater Thomas
  *Reviewer Wailed
  *
  */

packagecontrollers.manager

import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}

/**
  * Created Thomas on 2018/09/24
  */
class ManagerController @Inject()(cc: ControllerComponents) extends AbstractController(cc)  {
 
 def index = Action {
    Ok("Manager controller is working")
}


}
