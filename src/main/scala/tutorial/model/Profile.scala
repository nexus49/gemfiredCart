package tutorial.model;

import java.io.Serializable
import java.util.HashSet
import java.util.Set

import com.gemstone.bp.edu.emory.mathcs.backport.java.util.Collections

/**
 * A profile for a user of the gemstone social networking application. The
 * profile contains the list of friends of this person.
 * 
 * Profiles are used as the value in the people region. They will be distributed
 * to other VMs, so they must be serializable.
 * 
 * @author GemStone Systems, Inc.
 */
class Profile extends Serializable {
 val  serialVersionUID:Long = -3569243165627161127L

  val friends:Set[String] = Set[String]
  
  def addFriendL(name:String):Boolean ={ this.friends.add(name) }
  
  def removeFriend(name:String):Boolean ={ this.friends.remove(name) }
  
  def getFriends():Set[String] ={ Collections.unmodifiableSet(friends) }

  
  override def toString():String ={ "Profile [friends=" + friends + "]" }
}
