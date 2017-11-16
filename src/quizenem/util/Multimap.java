package quizenem.util;    

import java.util.ArrayList;    
import java.util.HashMap;    
import java.util.List;    

/**    
 * A simple implementation of a MultiMap. This implementation allows duplicate elements in the the    
 * values. (I know classes like this are out there but the ones available to me didn't work).    
 */    
public class Multimap<K, V> extends HashMap<K, List<V>> {    

  /**    
   * Looks for a list that is mapped to the given key. If there is not one then a new one is created    
   * mapped and has the value added to it.    
   *     
   * @param key    
   * @param value    
   * @return true if the list has already been created, false if a new list is created.    
   */    
  public boolean putOne(K key, V value) {    
    if (this.containsKey(key)) {    
      this.get(key).add(value);    
      return true;    
    } else {    
      List<V> values = new ArrayList<>();    
      values.add(value);    
      this.put(key, values);    
      return false;    
    }    
  }    
} 