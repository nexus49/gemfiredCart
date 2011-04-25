package com.cartservice.storage;

import static com.gemstone.gemfire.cache.RegionShortcut.PARTITION_REDUNDANT;
import static com.gemstone.gemfire.cache.RegionShortcut.REPLICATE;
import static com.gemstone.gemfire.cache.client.ClientRegionShortcut.CACHING_PROXY;
import static com.gemstone.gemfire.cache.client.ClientRegionShortcut.PROXY;

import java.util.Set;

import com.cartservice.model.Cart;
import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.distributed.internal.DistributionAdvisor;

/**
 * Data Access Object to store people and posts using GemFire. Calling the
 * {@link #initPeer()} method will connect this object to the GemFire
 * distributed system as a GemFire peer. Calling the {@link #initClient()} will
 * connect to the distributed system as a GemFire client.
 * <p/>
 * Once one of the init method is called, the rest of the methods in this DAO
 * can be used to query and update the store.
 *
 * @author GemStone Systems, Inc.
 */
public class GemfireDAO {

    private static GemfireDAO instance = null;

    public static GemfireDAO getInstance() {
        if (instance == null) {

            GemfireDAO inst = new GemfireDAO();
            inst.initPeer();
            instance = inst;
        }
        return instance;
    }

private Region<String, Cart>carts;
private boolean isClient;

/**
 * Connect to the distributed system as a peer and declare
 * the people and posts regions.
 */
public void initPeer(){
        //Connect to the distributed system. We're connecting to a known locator,
        //which GemFire will use to discover other peers.
        Cache cache=new CacheFactory()
        .set("locators","localhost[55221]")
        .set("mcast-port","0")
        .set("log-level","error")
        .create();

//Create a listener that will print to standard out
LoggingCacheListener listener=new LoggingCacheListener();

//Declare the people region. After this call completes,
//this member may have copied the contents of the region
//from a peer
carts=cache.<String, Cart>createRegionFactory(REPLICATE)
        .addCacheListener(listener)
        .create("carts");


}

/** Connect to the distributed system as a client and
 * declare the people and posts regions
 */
public void initClient(){
        //Connect to the system as a client. We're using a known locator
        //to discover servers in the distributed system.
        //
        //In addition, this client can subscribe to updates
        //from the servers.
        ClientCache cache=new ClientCacheFactory()
        .addPoolLocator("localhost",55221)
        .setPoolSubscriptionEnabled(true)
        .setPoolSubscriptionRedundancy(1)
        .set("log-level","error")
        .create();

//Create a listener that will print to standard out
LoggingCacheListener listener=new LoggingCacheListener();

//Declare the people region.
carts=cache.<String, Cart>createClientRegionFactory(CACHING_PROXY)
        .addCacheListener(listener)
        .create("people");

//Subscribe to updates for the people region. We're
//subscribing to all updates to this region so we can
//cache the people locally.
carts.registerInterestRegex(".*");

isClient=true;
}

/**
 * Add a new person
 * @param cartId The name of the person to add.
 * @param cart The profile for this person
 */
public void addCart(String cartId,Cart cart){
        carts.put(cartId,cart);
}

/**
 * Get this list of people in the system
 */
public Set<String>getCartIds(){
        return carts.keySet();
}

/**
 * Get the profile of a specific person
 *
 * @param person
 *          the persons name
 * @return the profile for the person, or null if the person is not in the
 *         system
 */
public Cart getCart(String cartId){
        return carts.get(cartId);
}
        }
