package repositories.assessment.tables

import java.time.LocalDateTime

import com.outworkers.phantom.dsl._
import com.outworkers.phantom.jdk8._
import com.outworkers.phantom.streams._
import domain.assessments.Exam

import scala.concurrent.Future

abstract class ExamTable extends Table[ExamTable, Exam] {
  
  object examId extends StringColumn with PrimaryKey
  
  object subjectId extends StringColumn with PartitionKey

  object subjectName extends StringColumn with PrimaryKey with ClusteringOrder with Ascending

  object venueNo extends StringColumn

  object examTime extends StringColumn
  
  object examController extends StringColumn
  
  object examDate extends Col[LocalDateTime] with PrimaryKey with ClusteringOrder with Ascending

}

abstract class ExamTableImpl extends ExamTable with RootConnector {

  override lazy val tableName = "exam"

  def save(exam: Exam): Future[ResultSet] = {
    insert
      .value(_.examId, exam.examId)
      .value(_.subjectId, exam.subjectId)
      .value(_.subjectName, exam.subjectName)
      .value(_.venueNo, exam.venueNo)
      .value(_.examTime, exam.examTime)
      .value(_.examController,exam.examController)
      .value(_.examDate, exam.examDate)
      .future()
  }

  def getExam(subjectId:String, venueNo:String, examDate:LocalDateTime): Future[Seq[Exam]] = {
    select
      .where(_.subjectId eqs subjectId)
      .and(_.venueNo eqs venueNo)
      .and(_.examDate eqs examDate)
      .fetchEnumerator() run Iteratee.collect()
  }

  def deleteExam(subjectId:String, venueNo:String, examDate:LocalDateTime):Future[ResultSet] ={
    delete
      .where(_.subjectId eqs subjectId)
      .and(_.venueNo eqs venueNo)
      .and(_.examDate eqs examDate)
      .future()
  }
}
