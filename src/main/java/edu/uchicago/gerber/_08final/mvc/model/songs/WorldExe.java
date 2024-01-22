package edu.uchicago.gerber._08final.mvc.model.songs;

import edu.uchicago.gerber._08final.mvc.model.SongMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldExe extends SongMap {
    public WorldExe() {
        super.songName = "world.execute(me);";
        super.BPM = 130;
        int minInterval = (int) ((60.0 / BPM / 2) * 100);  // the duration of an eighth note
//        System.out.println(minInterval + " min");
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
    }

    private void addFrames() {
        keyFrames.add(new ArrayList<Object>() {{
            add(444);
            add(Arrays.asList(0.5f, 0.5f, 1f));
            add(Arrays.asList("don", "kat", "don"));
        }});
        keyFrames.add(new ArrayList<Object>() {{
            add(608);
            add(Arrays.asList(0.5f, 0.5f, 1f));
            add(Arrays.asList("don", "don", "don"));
        }});
        keyFrames.add(new ArrayList<Object>() {{
            add(720);
            add(Arrays.asList(1f, 2.5f, 0.5f, 4f, 3f, 0.5f, 0.5f, 1f));
            add(Arrays.asList("don", "kat", "kat", "don", "don", "don", "kat", "don"));
        }});
        keyFrames.add(new ArrayList<Object>() {{
            add(1165);
            add(Arrays.asList(1f, 3f, 0.5f, 0.5f, 3f, 1f, 3f, 0.5f, 0.5f, 2.5f));
            add(Arrays.asList("don", "kat", "don", "kat", "kat", "don", "kat", "don", "kat", "kat"));
        }});
        keyFrames.add(new ArrayList<Object>() {{
            add(1562);
            add(Arrays.asList(2f, 2f, 2.5f, 0.5f, 0.5f, 3f, 0.5f, 0.5f, 2f));
            add(Arrays.asList("don", "don", "kat", "don", "don", "kat", "don", "kat", "kat"));
        }});
        // execution
        keyFrames.add(new ArrayList<Object>() {{
            add(1926);
            add(Arrays.asList(4f, 4f, 4f, 4f));
            add(Arrays.asList("don", "don", "don", "don"));
        }});
        keyFrames.add(new ArrayList<Object>() {{
            add(2289);
            add(Arrays.asList(0.5f, 3.5f, 0.5f, 3.5f, 0.5f, 3.5f, 0.5f, 3.5f));
            add(Arrays.asList("don", "don", "kat", "kat", "don", "don", "kat", "kat"));
        }});
        keyFrames.add(new ArrayList<Object>() {{
            add(2660);
            add(Arrays.asList(1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f));
            add(Arrays.asList("don", "kat", "kat", "kat", "don", "kat", "kat", "kat", "don", "kat", "kat", "don", "don", "kat", "kat", "kat"));
        }});
        keyFrames.add(new ArrayList<Object>() {{
            add(3028);
            add(Arrays.asList(2f, 2f, 2f, 2f, 2f, 2f, 1f, 1f, 1f, 1f));
            add(Arrays.asList("don", "don", "don", "don", "don", "don", "kat", "kat", "kat", "kat"));
        }});
        // if I can
        keyFrames.add(new ArrayList<Object>() {{
            add(3400);
            add(Arrays.asList(2f, 1f, 1f, 2f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f));
            add(Arrays.asList("don", "kat", "kat", "don", "kat", "kat", "don", "kat", "don", "kat", "don", "kat", "kat", "kat"));
        }});
        keyFrames.add(new ArrayList<Object>() {{
            add(3765);
            add(Arrays.asList(2f, 1f, 1f, 2f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f));
            add(Arrays.asList("kat", "don", "don", "kat", "don", "don", "kat", "don", "kat", "don", "kat", "don", "don", "don"));
        }});
        // if I can
        keyFrames.add(new ArrayList<Object>() {{
            add(4134);
            add(Arrays.asList(2f, 1f, 1f, 2f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f));
            add(Arrays.asList("don", "kat", "kat", "don", "kat", "kat", "don", "kat", "don", "kat", "don", "kat", "kat", "kat"));
        }});
        keyFrames.add(new ArrayList<Object>() {{
            add(4506);
            add(Arrays.asList(2f, 1f, 1f, 2f, 1f, 1f, 2f, 1f, 1f, 1f, 1f, 2f));
            add(Arrays.asList("kat", "don", "don", "kat", "don", "don", "kat", "don", "kat", "don", "kat", "don"));
        }});
        // I've studied
        keyFrames.add(new ArrayList<Object>() {{
            add(4876);
            add(Arrays.asList(2f, 1f, 1f, 2f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f));
            add(Arrays.asList("don", "kat", "kat", "don", "kat", "kat", "don", "kat", "don", "kat", "kat", "kat", "kat", "kat"));
        }});
        keyFrames.add(new ArrayList<Object>() {{
            add(5244);
            add(Arrays.asList(2f, 1f, 1f, 2f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f));
            add(Arrays.asList("don", "kat", "kat", "don", "kat", "kat", "don", "kat", "don", "kat", "kat", "kat", "kat", "kat"));
        }});
        // Find answer
        keyFrames.add(new ArrayList<Object>() {{
            add(5611);
            add(Arrays.asList(2f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f));
            add(Arrays.asList("don", "kat", "kat", "don", "kat", "kat", "kat", "don", "kat", "don", "kat", "kat", "kat", "kat", "kat"));
        }});
        keyFrames.add(new ArrayList<Object>() {{
            add(5987);
            add(Arrays.asList(2f, 1f, 1f, 2f, 1f, 1f, 2f, 2f, 2f, 2f));
            add(Arrays.asList("don", "kat", "kat", "don", "kat", "kat", "don", "don", "don", "don"));
        }});
        // outro
        keyFrames.add(new ArrayList<Object>() {{
            add(6350);
            add(Arrays.asList(2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 4f, 4f, 4f, 4f, 4f, 4f, 4f, 1f, 1f, 1f, 1f));
            add(Arrays.asList("don", "kat", "kat", "don", "don", "kat", "don", "kat", "don", "kat", "kat", "don", "don", "kat", "don", "kat", "don", "kat", "kat", "don", "don", "kat", "don", "don", "kat", "kat", "kat"));
        }});
        // ending signal
        keyFrames.add(new ArrayList<Object>() {{
            add(8200);
            add(Arrays.asList(1f));
            add(Arrays.asList("end"));
        }});
    }
}
