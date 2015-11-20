package tw.com.chttl.scala.sql.util

import java.sql.{Statement, ResultSet, Connection, DriverManager}

/**
 * Created by leorick on 2015/11/20.
 */
object JdbcHelper {
  def printResult(res:ResultSet) = {
    while(res.next) {
      val colcnt = res.getMetaData().getColumnCount()
      for ( i <- 1 until colcnt) {
        printf("%s,", res.getString(i) )
      }
      println(res.getString(colcnt))
    }
  }

  def getConn(driverName:String, uri:String, user:String, pwd:String) = {
    val conn = DriverManager.getConnection(uri, user, pwd)
    conn
  }

  def getStmt(conn:Connection) = {
    val stmt = conn.createStatement()
    stmt
  }

  def getResult(stmt:Statement, sql:String) = {
    val res = stmt.executeQuery(sql)
    res
  }

}
