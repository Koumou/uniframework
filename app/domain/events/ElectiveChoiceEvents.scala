package domain.events
import java.time.LocalDateTime

/**
  * @created by Kessel
  * @param studId student unique ID
  * @param subjId subject unique ID
  * @param eventDate
  */

case class ElectiveChoiceEvents( studId:String, subjId:String, eventDate:LocalDateTime)

object ElectiveChoiceEvents 
{
  implicit val ElectiveC = Json.format[ElectiveChoiceEvents];
  def identify: ElectiveChoiceEvents = ElectiveChoiceEvents ("","",LocalDateTime.now());
}
