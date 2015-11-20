package tw.com.chttl.scala.ldap.util

import javax.naming.NamingEnumeration
import javax.naming.directory.{Attribute, Attributes, SearchControls}

import scala.collection.mutable.ArrayBuffer

/**
 * Created by leorick on 2015/11/20.
 */
object LdapHelperTest {
  def main(args: Array[String]) {
    val client = LdapHelper.connect("ldap://10.176.32.8:389/ou=people,dc=cht,dc=local")
    val controls = new SearchControls()
    controls.setSearchScope(SearchControls.SUBTREE_SCOPE)
    val results: ArrayBuffer[Attributes] = client.search("","(objectclass=person)", controls)
    val output: ArrayBuffer[String] = results.map{attributes =>
      val enum: NamingEnumeration[_ <: Attribute] = attributes.getAll
      val attrs: ArrayBuffer[String] = ArrayBuffer[String]()
      while (enum.hasMore()) {
        attrs += (enum.next()).toString
      }
      attrs.mkString("[",",","]")
    }
    println(output.head)
    /*
[sn: 720user,userPassword: [B@136c2849,loginShell: /bin/bash,uidNumber: 10000,gidNumber: 10000,objectClass: posixAccount, inetOrgPerson, organizationalPerson, person,uid: 720user,cn: 720user,homeDirectory: /home/720user]
     */
  }
}
