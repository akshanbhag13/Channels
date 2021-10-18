/**
 * Homework 7 - Video
 * <p>
 * The Video class represents common details about a video uploaded to a video sharing platform.
 * Each video is created by a Channel.
 */
public class Video {
    /**
     * Name of the video.
     */
    private final String videoName;
    /**
     * Channel which created the video.
     */
    private final Channel channel;
    /**
     * Length of video in seconds
     */
    private final int duration;
    /**
     * Number of views for the video, initialized at zero.
     */
    private int numViews;

    public Video(String videoName, Channel channel, int minutes, int seconds) {
        this.videoName = videoName;
        this.channel = channel;
        duration = (minutes * 60) + seconds;
        numViews = 0;
    }

    public String getVideoName() {
        return videoName;
    }

    public Channel getChannel() {
        return channel;
    }

    public String getDuration() {
        int minutes = duration / 60;
        int seconds = duration % 60;
        String newMinutes = "";
        String newSeconds = "";

        if (minutes < 10) {
            newMinutes = "0" + minutes;
        } else {
            newMinutes += minutes;
        }

        if (seconds < 10) {
            newSeconds = "0" + seconds;
        } else {
            newSeconds += seconds;
        }

        return newMinutes + ":" + newSeconds;
    }

    public void addView() {
        numViews++;
    }

    public int getViews() {
        return numViews;
    }

    public void setViews(int numViews) {
        this.numViews = numViews;
    }

    public String toString() {
        return "Video[" + videoName + ", " + channel.getChannelName() + ", " + getDuration() + ", " + numViews + "]";
    }
}
