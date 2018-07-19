package repositories.courses

import com.outworkers.phantom.dsl._
import conf.connections.DataConnection
import repositories.courses.tables.CourseTableImpl

class CourseDatabase(override val connector: KeySpaceDef) extends Database[CourseDatabase](connector)
{
  object courseTable extends CourseTableImpl with connector.Connector
}

  object CourseDatabase extends CourseDatabase(DataConnection.connector)
  
  trait CourseRepository
  {
    def database = CourseDatabase
  }