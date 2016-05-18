package com.icaboalo.aplications;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by icaboalo on 17/05/16.
 */
public class AppModel extends RealmObject implements Serializable {


    public int position;
    public String name;
    public String image;
    public String category;

    @PrimaryKey
    public String link;
    public String rights;
    public String summary;
    public String releaseDate;
    public String appPackage;

}
