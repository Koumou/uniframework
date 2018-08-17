package services.places
import com.datastax.driver.core.ResultSet
import domain.pdomain.courses.Place
import services.courses.Impl.StaffSubjectImpl

/*
* created by Thomas Miller
* 216074630
*/

import scala.concurrent.Futur


trait StaffSubjectServices {

def save(staffSubject: StaffSubject): Future[ResultSet]
def getEntities(id: String): Future[Seq[Entity]]
def deleteStaffSubject(id: String): Future[ResultSet]
}
object StaffSubjectServices{
def apply: EntityServices = new StaffSubjectServicesImpl
}