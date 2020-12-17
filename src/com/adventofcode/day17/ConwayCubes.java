package com.adventofcode.day17;

import java.util.ArrayList;
import java.util.List;

public class ConwayCubes {

    public static int countActiveCubes4D(List<List<List<List<Character>>>> map4D) {
        int count = 0;

        for (List<List<List<Character>>> w : map4D) {
            count += countActiveCubes(w);
        }

        return count;
    }

    public static int countActiveCubes(List<List<List<Character>>> map3D) {
        int count = 0;

        for (List<List<Character>> z : map3D) {
            for (List<Character> y : z) {
                for (Character x : y) {
                    if (x.equals('#')) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static List<List<List<List<Character>>>> cycle4D(List<List<List<List<Character>>>> map4D) {
        //Enlarge map3D with inactive points
        enlargeMap4D(map4D);

        List<List<List<List<Character>>>> map4DCopy = copy4DMap(map4D);

        for (int w = 0; w < map4DCopy.size(); w++) {
            //TODO: how?
        }

        return map4DCopy;
    }

    private static List<List<List<List<Character>>>> copy4DMap(List<List<List<List<Character>>>> map4D) {
        List<List<List<List<Character>>>> map4DCopy = new ArrayList<>();
        for (List<List<List<Character>>> map3D : map4D) {
            map4DCopy.add(copy3DMap(map3D));
        }
        return map4DCopy;
    }

    private static void enlargeMap4D(List<List<List<List<Character>>>> map4D) {

        //x axis size
        int currentCubeSize = map4D.get(0).size();
        for (List<List<List<Character>>> map3D : map4D) {
            enlargeMap(map3D);
        }

        List<Character> empty1DMap = new ArrayList<>();
        for (int i = 0; i < currentCubeSize + 2; i++) {
            empty1DMap.add('.');
        }
        List<List<Character>> empty2DMap = new ArrayList<>();
        for (int i = 0; i < currentCubeSize + 2; i++) {
            empty2DMap.add(empty1DMap);
        }
        List<List<List<Character>>> empty3DMap = new ArrayList<>();
        for (int i = 0; i < currentCubeSize + 2; i++) {
            empty3DMap.add(empty2DMap);
        }
        map4D.add(map4D.size(), empty3DMap);
        map4D.add(0, empty3DMap);

    }

    public static List<List<List<Character>>> cycle(List<List<List<Character>>> map3D) {
        //Enlarge map3D with inactive points
        enlargeMap(map3D);

        List<List<List<Character>>> map3DCopy = copy3DMap(map3D);

        for (int z = 0; z < map3D.size(); z++) {
            for (int y = 0; y < map3D.get(z).size(); y++) {
                for (int x = 0; x < map3D.get(z).get(y).size(); x++) {
                    int countActive = countActiveNearby(map3D, x, y, z);
                    if (map3D.get(z).get(y).get(x).equals('#')) {
                        if ((countActive < 2) || (countActive > 3)) {
                            replaceSymbolForXAxis(map3DCopy, z, y, x, '.');
                        }
                    }
                    if (map3D.get(z).get(y).get(x).equals('.')) {
                        if (countActive == 3) {
                            replaceSymbolForXAxis(map3DCopy, z, y, x, '#');
                        }
                    }
                }
            }
        }

        return map3DCopy;
    }

    private static void enlargeMap(List<List<List<Character>>> map3D) {
        //x axis size
        int currentCubeSize = map3D.get(0).get(0).size();
        List<Character> empty1DMap = new ArrayList<>();
        for (int i = 0; i < currentCubeSize + 2; i++) {
            empty1DMap.add('.');
        }

        List<List<Character>> empty2DMap = new ArrayList<>();
        for (int i = 0; i < currentCubeSize + 2; i++) {
            empty2DMap.add(empty1DMap);
        }

        for (List<List<Character>> map2D : map3D) {
            for (List<Character> map1D : map2D) {
                map1D.add(map1D.size(), '.');
                map1D.add(0, '.');
            }
            map2D.add(map2D.size(), empty1DMap);
            map2D.add(0, empty1DMap);
        }

        map3D.add(map3D.size(), empty2DMap);
        map3D.add(0, empty2DMap);
    }

    public static List<List<List<Character>>> copy3DMap(List<List<List<Character>>> map3D) {
        List<List<List<Character>>> map3DCopy = new ArrayList<>();

        for (List<List<Character>> z : map3D) {
            List<List<Character>> zCopy = new ArrayList<>();
            for (List<Character> y : z) {
                zCopy.add(new ArrayList<>(y));
            }
            map3DCopy.add(zCopy);
        }

        return map3DCopy;
    }

    private static void replaceSymbolForXAxis(List<List<List<Character>>> map3DCopy, int z, int y, int x, char c) {
        map3DCopy.get(z).get(y).remove(x);
        map3DCopy.get(z).get(y).add(x, c);
    }

    public static int countActiveNearby(List<List<List<Character>>> map3D, int x, int y, int z) {
        int count = 0;

        //lower layer
        try {
            count += countIn3x3Layer(map3D.get(z - 1), x, y);
        } catch (Exception e) {
        }

        //middle layer
        count += countIn3x3Layer(map3D.get(z), x, y);
        if (map3D.get(z).get(y).get(x).equals('#')) {
            count--;
        }

        //upper layer
        try {
            count += countIn3x3Layer(map3D.get(z + 1), x, y);
        } catch (Exception e) {
        }

        return count;
    }

    public static int countIn3x3Layer(List<List<Character>> map2D, int x, int y) {
        int count = 0;
        //Upper y
        try {
            if (map2D.get(y + 1).get(x + 1).equals('#')) {
                count++;
            }
        } catch (Exception e) {
        }
        try {
            if (map2D.get(y + 1).get(x).equals('#')) {
                count++;
            }
        } catch (Exception e) {
        }
        try {
            if (map2D.get(y + 1).get(x - 1).equals('#')) {
                count++;
            }
        } catch (Exception e) {
        }

        //Middle y
        try {
            if (map2D.get(y).get(x + 1).equals('#')) {
                count++;
            }
        } catch (Exception e) {
        }
        try {
            if (map2D.get(y).get(x).equals('#')) {
                count++;
            }
        } catch (Exception e) {
        }
        try {
            if (map2D.get(y).get(x - 1).equals('#')) {
                count++;
            }
        } catch (Exception e) {
        }

        //Lower y
        try {
            if (map2D.get(y - 1).get(x + 1).equals('#')) {
                count++;
            }
        } catch (Exception e) {
        }
        try {
            if (map2D.get(y - 1).get(x).equals('#')) {
                count++;
            }
        } catch (Exception e) {
        }
        try {
            if (map2D.get(y - 1).get(x - 1).equals('#')) {
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

}
