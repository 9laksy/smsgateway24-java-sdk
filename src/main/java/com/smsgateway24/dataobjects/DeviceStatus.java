package com.smsgateway24.dataobjects;

/**
 *
 * @author laks
 */
public class DeviceStatus {

    private LastSeenDate lastseen;
    private long device_id;
    private String title;

    public DeviceStatus(LastSeenDate lastSeenDate, int device_id, String title) {
        this.lastseen = lastSeenDate;
        this.device_id = device_id;
        this.title = title;
    }

    public LastSeenDate getLastseen() {
        return lastseen;
    }

    public void setLastseen(LastSeenDate lastseen) {
        this.lastseen = lastseen;
    }

    public long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(long device_id) {
        this.device_id = device_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
