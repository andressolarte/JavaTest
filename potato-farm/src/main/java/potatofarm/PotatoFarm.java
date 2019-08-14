package potatofarm;

import lombok.extern.java.Log;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;


@Log
public class PotatoFarm {
    public static void main(String[] args) {

        List<Potato> crop = expectedPotatoes();

        PotatoFarm potatoFarm = new PotatoFarm();

    }

    private List<Potato> safeEngineerCropV2(List<Potato> normalCrop) {

        List<Potato> engineeredCropV2 = normalCrop.stream().map(x ->
                x.toBuilder()
                        .eye(x.getEye().toBuilder().build())
                        .build()
        ).collect(Collectors.toList());

        engineeredCropV2.get(0).setColor(Color.ORANGE);
        engineeredCropV2.get(0).setSize(1753);
        engineeredCropV2.get(0).setName("Bridgette");
        engineeredCropV2.get(0).getEye().setLength(15646);
        engineeredCropV2.get(1).setColor(Color.BLACK);
        engineeredCropV2.get(1).setSize(2051);
        engineeredCropV2.get(1).getEye().setLength(89615);
        engineeredCropV2.get(2).setColor(Color.TANGERINE);
        engineeredCropV2.get(2).setSize(2761);
        engineeredCropV2.get(2).getEye().setLength(324654);

        return engineeredCropV2;

    }

    private List<Potato> safeEngineerCrop(List<Potato> normalCrop) {

        List<Potato> engineeredCrop = normalCrop.stream().map(x -> x.toBuilder().build()).collect(Collectors.toList());

        engineeredCrop.get(0).setColor(Color.ORANGE);
        engineeredCrop.get(0).setSize(1753);
        engineeredCrop.get(0).getEye().setLength(15646);
        engineeredCrop.get(1).setColor(Color.BLACK);
        engineeredCrop.get(1).setSize(2051);
        engineeredCrop.get(1).getEye().setLength(89615);
        engineeredCrop.get(2).setColor(Color.TANGERINE);
        engineeredCrop.get(2).setSize(2761);
        engineeredCrop.get(2).getEye().setLength(324654);

        return engineeredCrop;

    }

    private List<Potato> engineerCrop(List<Potato> normalCrop) {

        List<Potato> engineeredCrop = newArrayList(normalCrop);

        engineeredCrop.get(0).setColor(Color.ORANGE);
        engineeredCrop.get(0).setSize(1753);
        engineeredCrop.get(0).getEye().setLength(15646);
        engineeredCrop.get(1).setColor(Color.BLACK);
        engineeredCrop.get(1).setSize(2051);
        engineeredCrop.get(1).getEye().setLength(89615);
        engineeredCrop.get(2).setColor(Color.TANGERINE);
        engineeredCrop.get(2).setSize(2761);
        engineeredCrop.get(2).getEye().setLength(324654);

        return engineeredCrop;

    }

    private List<Potato> mutateClone(List<Potato> cropClone) {

        Eye newEye = Eye.builder().length(3).dreams(newArrayList("Sleep", "Money", "World Domination")).build();

        List<Potato> mutatedClones = newArrayList(cropClone);
        mutatedClones.add(Potato.builder().color(Color.PURPLE).eye(newEye).name("เนยแข็ง").size(23).build());

        return mutatedClones;
    }

    private void printPotatoes(List<Potato> potatoes) {

        potatoes.forEach(System.out::println);
    }

    private List<Potato> clonePotato(List<Potato> naturalPotatoes) {

        return newArrayList(naturalPotatoes);
    }

    private void validatePotatoes(List<Potato> actualPotatoes, String cropName) throws Exception {

        if(!expectedPotatoes().equals(actualPotatoes)) {
            throw new Exception("No Match");
        }

        log.info(cropName + " is unchanged");
    }

    private static List<Potato> expectedPotatoes() {
        Eye eye1 = Eye.builder().length(17).dreams(newArrayList("Peace", "Happiness", "Long, flowing hair")).build();
        Eye eye2 = Eye.builder().length(102).dreams(newArrayList("Chocolate", "Honey", "Live on Mars")).build();
        Eye eye3 = Eye.builder().length(42).dreams(newArrayList("Art", "Love", "Life", "Pizza")).build();

        Potato potato1 = Potato.builder().color(Color.RED).eye(eye1).name("Todd").size(7).build();
        Potato potato2 = Potato.builder().color(Color.WHITE).eye(eye2).name("Rebecca").size(13).build();
        Potato potato3 = Potato.builder().color(Color.BROWN).eye(eye3).name("Prince").size(17).build();

        return newArrayList(potato1, potato2, potato3);
    }
}
