package edu.uchicago.gerber._08final.mvc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SongMap {
    public Map<Integer, String> map = new HashMap<>();
    public List<ArrayList<Object>> keyFrames = new ArrayList<>();
    public String songName;
    public int BPM;
}
