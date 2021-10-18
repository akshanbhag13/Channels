/**
 * Homework 7 - Channel
 * <p>
 * The Channel class represents details about a content uploader.
 * This includes their channel name, subscribers, an array of Video
 * objects created by them, and the number of uploads.
 */
public class Channel {
    /**
     * Name of the channel
     */
    private final String channelName;
    /**
     * Number of subscribers of this channel
     */
    private int channelSubscribers;
    /**
     * Number of videos uploaded by this channel. This may be of use when iterating through the videos array.
     */
    private int numUploads;
    /**
     * An array containing videos uploaded by this creator.
     */
    private Video[] videos;

    public Channel(String channelName) {
        this.channelName = channelName;
        channelSubscribers = 0;
        numUploads = 0;
        videos = new Video[100];
    }

    public Channel(String channelName, int channelSubscribers, int numUploads, Video[] videos) {
        this.channelName = channelName;
        this.channelSubscribers = channelSubscribers;
        this.numUploads = numUploads;
        this.videos = videos;
    }

    public String getChannelName() {
        return channelName;
    }

    public int getChannelSubscribers() {
        return channelSubscribers;
    }

    public void setChannelSubscribers(int channelSubscribers) {
        this.channelSubscribers = channelSubscribers;
    }

    public void addChannelSubscriber() {
        channelSubscribers++;
    }

    public int getNumUploads() {
        return numUploads;
    }

    public Video[] getVideos() {
        return videos;
    }

    public void setVideos(Video[] videos, int numUploads) {
        this.videos = videos;
        this.numUploads = numUploads;
    }

    public boolean uploadVideo(Video video) {
        for (int i = 0; i < videos.length; i++) {
                if (videos[i] != null && videos[i].getVideoName().equals(video.getVideoName())) {
                    return false;
            }
        }


        if (numUploads < 100) {
            numUploads++;
            videos[numUploads - 1] = video;
            return true;
        } else {
            return false;
        }

    }

    public int getTotalViews() {
        int totalViews = 0;
        for (int i = 0; i < videos.length; i++) {
            if (videos[i] != null) {
                totalViews += videos[i].getViews();
            }
        }
        return totalViews;
    }

    public Video findVideo(String videoName) {
        for (int i = 0; i < videos.length; i++) {
            if (videos[i] != null && videos[i].getVideoName().equals(videoName)) {
                return videos[i];
            }
        }
        return null;
    }

    public String toString() {
        return "Channel[" + channelName + ", " + channelSubscribers + ", " + numUploads + "]";
    }
}
