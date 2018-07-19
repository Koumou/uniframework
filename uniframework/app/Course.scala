package domain.courses

import play.api.libs.json.Json

case class Course
(
    courseId:Integer, 
    courseName: String, 
    courseDuration:String
)

object Course
{
  implicit val venueJson = Json.format[Course]
  
  def identity: Course = Course(1, "Information Technology", "3 Years");
}
