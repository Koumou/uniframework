
/**
  *Creater Thomas
  *Reviewer Dorcas
  *
  */




package controllers.people

import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}

/**
  * Created Thomas on 2018/09/24
  */
class StudentSubjectsController @Inject()(cc: ControllerComponents) extends AbstractController(cc)  {
 
 def index = Action {
    Ok("Stusent Subject controller is working")
}


}
