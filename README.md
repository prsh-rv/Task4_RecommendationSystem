# Task 4 - Java Recommendation System using Apache Mahout

## 🤖 Description

This is a console-based recommendation system built in Java using Apache Mahout. It uses collaborative filtering to recommend items to a user based on other users with similar preferences. The system loads a ratings dataset and suggests the top 3 items that a user has not interacted with yet.

---


## 📂 Dataset

The dataset is stored in a file called `ratings.csv`, where each row represents a user ID, item ID, and the rating the user gave to that item.

Example format:
```
userID,itemID,rating
1,101,5.0
2,102,3.5
```

---


## 🛠 How to Run

### 1. Required Libraries (All included in this repo)

- mahout-core-0.9.jar
- mahout-math-0.9.jar
- commons-lang-2.6.jar
- guava-18.0.jar
- commons-math3-3.6.1.jar
- slf4j-api-1.7.25.jar

### 2. Compile the Java Program

Open terminal in the project folder and run:

```
javac -cp ".;mahout-core-0.9.jar;mahout-math-0.9.jar;commons-lang-2.6.jar;guava-18.0.jar;commons-math3-3.6.1.jar;slf4j-api-1.7.25.jar" RecommenderApp.java
```

(Use `:` instead of `;` on Linux/macOS)

### 3. Run the Program

```
java -cp ".;mahout-core-0.9.jar;mahout-math-0.9.jar;commons-lang-2.6.jar;guava-18.0.jar;commons-math3-3.6.1.jar;slf4j-api-1.7.25.jar" RecommenderApp
```

You will be prompted to enter a user ID (e.g., 1 to 5). The app will display item recommendations based on similar users' preferences.

---


## 🧑‍💻 Features

- Collaborative filtering using Mahout
- Pearson correlation for user similarity
- Recommends top 3 unseen items for each user
- Interactive user input via terminal
- Real dataset parsing from a `.csv` file

---


## 📁 Files Included

- `RecommenderApp.java`: Java source code
- `ratings.csv`: User-item-rating dataset
- Required JAR files:
  - `mahout-core-0.9.jar`
  - `mahout-math-0.9.jar`
  - `commons-lang-2.6.jar`
  - `guava-18.0.jar`
  - `commons-math3-3.6.1.jar`
  - `slf4j-api-1.7.25.jar`
- `README.md`: This instruction file
- `screenshot.png`: Sample output (optional)
