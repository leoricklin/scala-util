package tw.com.chttl.scala.sql.util

/**
 * Created by leorick on 2015/11/20.
 */
object JdbcHelperTest {
  def main(args: Array[String]) {
    val driverName="com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://tf2p076.cht.local:3306/leo"
    val username = "leo"
    val password = "qazWSX"
    Class.forName(driverName).newInstance
    val conn = JdbcHelper.getConn(driverName, url, username, password)
    val stmt = JdbcHelper.getStmt(conn)
    val sql="select count(*) from v_turdr_sum1_app_5"
    val ret = JdbcHelper.getResult(stmt, sql)
    JdbcHelper.printResult(ret)
  }
}
