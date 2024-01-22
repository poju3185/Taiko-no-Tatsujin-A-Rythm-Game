package edu.uchicago.gerber._08final.mvc.model.songs;

import edu.uchicago.gerber._08final.mvc.model.SongMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YoruniKakeru extends SongMap {
    public YoruniKakeru() {
        super.songName = "Racing Into The Night";
        super.BPM = 130;
        int minInterval = (int) ((60.0 / BPM / 2) * 100);  // the duration of an eighth note
        addFrames();
        for (ArrayList<Object> keyFrameInfo : keyFrames) {
            int startFrame = (int) keyFrameInfo.get(0);

            List<Float> nodeValues = (List<Float>) keyFrameInfo.get(1);
            List<String> nodeTypes = (List<String>) keyFrameInfo.get(2);
            for (int i = 0; i < nodeValues.size(); i++) {
//                System.out.println(startFrame);
                super.map.put(startFrame, nodeTypes.get(i));
                startFrame += (int) (minInterval * nodeValues.get(i));
            }
        }

//        // 沈むように
//        super.map.put(300, "don"); // 2
//        super.map.put(392, "don"); // 2
//        super.map.put(484, "don"); // 2
//        super.map.put(576, "don"); // 4
//        super.map.put(622, "don"); // 4
//        super.map.put(668, "don"); // 4
//        // 二人だけの
//        super.map.put(1034, "don"); // 4
//        super.map.put(1080, "don"); // 4
//        super.map.put(1126, "don"); // 4
//        super.map.put(1167, "don"); // 8
//        super.map.put(1190, "kat"); // 8
//        super.map.put(1213, "don"); // 4
//        super.map.put(1259, "don"); // 4
//        super.map.put(1305, "don"); // 4
//        super.map.put(1351, "don"); // 8
//        super.map.put(1374, "kat"); // 8
//        super.map.put(1397, "don"); // 4
//        super.map.put(1443, "don"); // 4
//        super.map.put(1489, "don"); // 4
//        // Intro
//        // 1
//        super.map.put(1780, "don"); // 8
//        super.map.put(1803, "kat"); // 8
//        super.map.put(1826, "don"); // 4
//        // 2
//        super.map.put(1872, "don"); // 8
//        super.map.put(1895, "kat"); // 8
//        super.map.put(1918, "don"); // 4
//        // 3
//        super.map.put(1964, "don"); // 8
//        super.map.put(1987, "kat"); // 8
//        super.map.put(2010, "don"); // 4
//        // 4
//        super.map.put(2056, "don"); // 8
//        super.map.put(2079, "kat"); // 8
//        super.map.put(2102, "don"); // 4
//        // 5
//        super.map.put(2148, "don"); // 8
//        super.map.put(2171, "kat"); // 8
//        super.map.put(2197, "don"); // 4
    }

    private void addFrames() {
        // 沈むように
        keyFrames.add(new ArrayList<Object>() {{
            add(296);
            add(Arrays.asList(4f, 4f, 4f, 2f, 2f, 2f));
            add(Arrays.asList("don", "don", "don", "don", "don", "don"));
        }});
        // 二人だけの
        keyFrames.add(new ArrayList<Object>() {{
            add(1031);
            add(Arrays.asList(2f, 2f, 2f, 1f, 1f, 2f, 2f, 2f, 1f, 1f, 2f, 2f, 2f));
            add(Arrays.asList("don", "don", "don", "don", "kat", "don", "don", "don", "don", "kat", "don", "don", "don"));
        }});
        // Intro
        keyFrames.add(new ArrayList<Object>() {{
            add(1773);
            add(Arrays.asList(1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 1f, 1f, 2f));
            add(Arrays.asList("don", "kat", "don", "don", "kat", "don", "don", "kat", "don", "don", "kat", "don", "don", "kat", "don", "don", "kat", "don", "don", "kat", "don", "kat", "don"));
        }});
        // Intro 2
        keyFrames.add(new ArrayList<Object>() {{
            add(2513);
            add(Arrays.asList(1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 1f, 1f, 1f));
            add(Arrays.asList("don", "kat", "don", "don", "kat", "don", "don", "kat", "don", "don", "kat", "don", "don", "kat", "don", "don", "kat", "don", "don", "don", "don", "don", "don"));
        }});
        // さようなら
        keyFrames.add(new ArrayList<Object>() {{
            add(3255);
            add(Arrays.asList(2f, 2f, 4f, 2f, 2f, 1f, 1f, 2f, 2f, 2f, 4f, 2f, 2f, 1f, 1f, 2f));
            add(Arrays.asList("don", "kat", "don", "don", "kat", "don", "kat", "kat", "don", "kat", "don", "don", "kat", "don", "kat", "kat"));
        }});
        // 出した空と
        keyFrames.add(new ArrayList<Object>() {{
            add(3995);
            add(Arrays.asList(2f, 2f, 2f, 1f, 1f, 2f, 2f, 1f, 1f, 2f, 2f, 2f, 2f, 1f, 2f, 1f, 2f, 1.5f, 1.5f, 1f));
            add(Arrays.asList("don", "kat", "don", "kat", "don", "don", "kat", "don", "kat", "kat", "don", "kat", "don", "kat", "don", "don", "kat", "don", "don", "don"));
        }});
        // 初めて会った
        keyFrames.add(new ArrayList<Object>() {{
            add(4732);
            add(Arrays.asList(2f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 2f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 2f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 2f));
            add(Arrays.asList("don", "kat", "don", "don", "kat", "don", "don", "kat", "don", "kat", "kat", "don", "kat", "don", "don", "kat", "don", "don", "kat", "don", "kat", "kat", "don", "kat", "don", "don", "kat", "don", "don", "kat", "don", "kat", "kat"));
        }});
        // 寂しい目
        keyFrames.add(new ArrayList<Object>() {{
            add(5840);
            add(Arrays.asList(2f, 2f, 1f, 1f, 1f, 2f, 1f, 2f, 1.5f, 1.5f, 2f));
            add(Arrays.asList("don", "kat", "don", "don", "kat", "don", "don", "kat", "kat", "kat", "kat"));
        }});
        // チックタックと
        keyFrames.add(new ArrayList<Object>() {{
            add(6209);
            add(Arrays.asList(1.5f, 1.5f, 2f, 1f, 2f));
            add(Arrays.asList("don", "don", "don", "don", "kat"));
        }});
        // 何度だってさ
        keyFrames.add(new ArrayList<Object>() {{
            add(6397);
            add(Arrays.asList(1.5f, 1.5f, 2f, 1f, 2.5f, 1f, 2.5f, 1f, 2.5f, 1f, 2.5f));
            add(Arrays.asList("don", "don", "don", "don", "kat", "don", "kat", "don", "kat", "don", "kat"));
        }});
        // 零れそうでも
        keyFrames.add(new ArrayList<Object>() {{
            add(6855);
            add(Arrays.asList(2f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 2f));
            add(Arrays.asList("don", "kat", "don", "kat", "don", "don", "kat", "don", "don", "kat", "don", "don", "kat", "don"));
        }});
        // 二人なら
        keyFrames.add(new ArrayList<Object>() {{
            add(7321);
            add(Arrays.asList(1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f));
            add(Arrays.asList("don", "kat", "don", "kat", "don", "kat", "don", "kat", "don"));
        }});
        // 騒がしい
        keyFrames.add(new ArrayList<Object>() {{
            add(7687);
            add(Arrays.asList(2f, 2f, 2f, 2f, 2f, 1f, 1f, 2f));
            add(Arrays.asList("don", "kat", "don", "kat", "don", "don", "kat", "don"));
        }});
        // 思い付く
        keyFrames.add(new ArrayList<Object>() {{
            add(8005);
            add(Arrays.asList(1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 2f, 1f, 1f, 2f));
            add(Arrays.asList("kat", "kat", "don", "don", "kat", "kat", "don", "don", "kat", "kat", "don", "don", "kat", "don"));
        }});
        // 明けない夜に
        keyFrames.add(new ArrayList<Object>() {{
            add(8373);
            add(Arrays.asList(1f, 1f, 2f, 1f, 1f, 2f, 2f, 2f, 1f, 1f, 2f, 2f));
            add(Arrays.asList("kat", "kat", "don", "don", "kat", "don", "kat", "don", "don", "kat", "don", "kat"));
        }});
        // 僕の手を
        keyFrames.add(new ArrayList<Object>() {{
            add(8793);
            add(Arrays.asList(1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f));
            add(Arrays.asList("don", "kat", "don", "kat", "don", "kat", "don", "kat", "don"));
        }});
        // 忘れてしまいた
        keyFrames.add(new ArrayList<Object>() {{
            add(9159);
            add(Arrays.asList(2f, 2f, 2f, 2f, 2f, 1f, 1f, 2f));
            add(Arrays.asList("don", "kat", "don", "kat", "don", "don", "kat", "don"));
        }});
        // 抱きしめた
        keyFrames.add(new ArrayList<Object>() {{
            add(9482);
            add(Arrays.asList(1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 2f, 1f, 1f, 2f));
            add(Arrays.asList("kat", "kat", "don", "don", "kat", "kat", "don", "don", "kat", "kat", "don", "don", "kat", "don"));
        }});
        // 怖くないよ
        keyFrames.add(new ArrayList<Object>() {{
            add(9854);
            add(Arrays.asList(1f, 1f, 2f, 1f, 1f, 2f, 2f, 2f, 1f, 1f, 2f, 2f));
            add(Arrays.asList("kat", "kat", "don", "don", "kat", "don", "kat", "don", "don", "kat", "don", "kat"));
        }});
        // Ending
        keyFrames.add(new ArrayList<Object>() {{
            add(10455);
            add(Arrays.asList(1f));
            add(Arrays.asList("don"));
        }});
        // Ending signal
        keyFrames.add(new ArrayList<Object>() {{
            add(11060);
            add(Arrays.asList(1f));
            add(Arrays.asList("end"));
        }});
    }
}
