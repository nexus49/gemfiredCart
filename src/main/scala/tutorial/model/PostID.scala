package tutorial.model;

import java.io.Serializable;

/**
 * A PostID is a A unique ID for a post from a specific user. The ID of a post
 * is the a combination of the target and a timestamp.
 * 
 * The PostID is used as the key for the posts region. Because of that, it 
 * must implement equals and hashCode. It must also be Serializable
 * so that it can be distributed other VMs.
 * 
 * @author GemStone Systems, Inc.
 */
class PostID(val target:String, val timestamp:Long) extends Serializable() {
  val serialVersionUID:Long = 1
  
  override def hashCode():Int ={
    val prime = 31
    var result = 1
    result = prime * result + ((author == null) ? 0 : target.hashCode)
    prime * result + (int) (timestamp ^ (timestamp >>> 32))
  }


  override def equals(obj:Object):Boolean ={
    if (this == obj)
      return true
    if (obj == null)
      return false
    if (!(obj instanceof PostID))
      return false
    val other:PostID  = obj.asInstanceOf[PostID]
    if (author == null) {
      if (other.author != null)
        return false
    } else if (!author.equals(other.author))
      return false
    if (timestamp != other.timestamp)
      return false
    true
  }

  override def  toString():String ={ "PostID [author=" + author + ", timestamp=" + timestamp + "]" }
  
}
