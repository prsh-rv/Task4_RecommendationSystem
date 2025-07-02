import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.util.*;

public class RecommenderApp {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Optional: Mapping item IDs to names
            Map<Long, String> itemNames = Map.of(
                101L, "Laptop",
                102L, "Mobile Phone",
                103L, "Headphones",
                104L, "Smartwatch",
                105L, "Tablet"
            );

            // Load the dataset
            DataModel model = new FileDataModel(new File("ratings.csv"));

            // Use Pearson correlation for similarity
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

            // Neighborhood = top 4 similar users
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(4, similarity, model);

            // Create the recommender
            UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

            System.out.println("Enter your user ID (1-5): ");
            int userId = scanner.nextInt();

            List<RecommendedItem> recommendations = recommender.recommend(userId, 3);

            System.out.println("\nTop Recommendations for You:");
            for (RecommendedItem item : recommendations) {
                String itemName = itemNames.getOrDefault(item.getItemID(), "Item " + item.getItemID());
                System.out.printf("- %s (score: %.2f)\n", itemName, item.getValue());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
