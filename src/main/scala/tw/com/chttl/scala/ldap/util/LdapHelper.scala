package tw.com.chttl.scala.ldap.util

import javax.naming.{NameNotFoundException, NamingException, Context, NamingEnumeration}
import javax.naming.directory.{Attributes, SearchControls, InitialDirContext, SearchResult}
import scala.collection.mutable.ArrayBuffer

/**
 * Created by leorick on 2015/11/20.
 */
object LdapHelper {
  val _env = new java.util.Hashtable[String, String]()
  var _ctx = None:Option[InitialDirContext]
  var _controls = None:Option[SearchControls]

  def connect(url:String): LdapHelper.type = {
    _env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory")
    _env.put(Context.PROVIDER_URL, url)
    _ctx = Some(new InitialDirContext(_env))
    _controls = Some(new SearchControls())
    _controls.get.setSearchScope(SearchControls.SUBTREE_SCOPE)
    this
  }

  def search(name:String = "", filter:String = "(objectclass=person)", controls:SearchControls = _controls.get ): ArrayBuffer[Attributes] = {
    val list = ArrayBuffer[Attributes]()
    var results = None:Option[NamingEnumeration[SearchResult]]
    try {
      results = Some(_ctx.get.search(name, filter, controls))
      while (results.get.hasMore()) {
        list += (results.get.next()).getAttributes()
      }
    } catch {
      case ne:NamingException => System.err.println(ne.getMessage)
      case nnfe:NameNotFoundException => System.err.println(nnfe.getMessage)
    } finally {
      if (results.isDefined) {
        try {
          results.get.close()
        } catch {
          case e:Exception => System.err.println(e.getMessage)
        }
      }
    }
    list
  }

  def close() = {
    if (_ctx.isDefined) {
      try {
        _ctx.get.close()
      } catch {
        case e:Exception => System.err.println(e.getMessage)
      }
    }
  }
}
