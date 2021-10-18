/**
 * Homework 7 - Profile
 * <p>
 * The Profile class represents details about a content viewer.
 * This includes their username, an array of Channel
 * objects representing content creators they've subscribed to, and the
 * number of channels subscribed to.
 */
public class Profile {
    /**
     * Username of the user
     */
    private final String username;
    /**
     * An array containing channels subscribed to by this user.
     */
    private Channel[] subscribed;
    /**
     * Number of channels subscribed to by this user
     */
    private int numSubscribed;

    public Profile(String username) {
        this.username = username;
        subscribed = new Channel[100];
        numSubscribed = 0;
    }

    public String getUsername() {
        return username;
    }

    public Channel[] getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Channel[] subscribed, int numSubscribed) {
        this.subscribed = subscribed;
        this.numSubscribed = numSubscribed;
    }

    public boolean subscribeToChannel(Channel channel) {
        for (int i = 0; i < subscribed.length; i++) {
            if (subscribed[i] != null && channel.getChannelName().equals(subscribed[i].getChannelName())) {
                return false;
            }
        }

        if (numSubscribed < 100) {
            channel.addChannelSubscriber();
            numSubscribed++;
            subscribed[numSubscribed - 1] = channel;
            return true;
        } else {
            return false;
        }
    }

    public Channel findChannel(String channelName) {
        for (int i = 0; i < subscribed.length; i++) {
            if (subscribed[i] != null && channelName.equals(subscribed[i].getChannelName())) {
                return subscribed[i];
            }
        }
        return null;
    }

    public String toString() {
        return "Profile[" + username + "]";
    }
}
