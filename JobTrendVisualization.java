import javax.swing.*;
import java.awt.*;
import java.util.*;

public class JobTrendVisualization extends JPanel {

    private Map<String, Integer> skillCount;

    public JobTrendVisualization(Map<String, Integer> skillCount) {
        this.skillCount = skillCount;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int barWidth = 80;
        int spacing = 40;
        int x = 50;

        int max = Collections.max(skillCount.values());

        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Trending Skills - Job Market Analysis", width / 4, 30);

        for (Map.Entry<String, Integer> entry : skillCount.entrySet()) {

            int value = entry.getValue();
            int barHeight = (value * 300) / max;

            g.setColor(Color.BLUE);
            g.fillRect(x, height - barHeight - 50, barWidth, barHeight);

            g.setColor(Color.BLACK);
            g.drawString(entry.getKey(), x + 10, height - 30);
            g.drawString(String.valueOf(value), x + 25, height - barHeight - 60);

            x += barWidth + spacing;
        }
    }

    public static void main(String[] args) {

        // Sample Dataset
        String[] skills = {"Java", "Python", "AWS", "AI", "Java", "Python", "Java", "AI"};

        Map<String, Integer> skillCount = new LinkedHashMap<>();

        for (String skill : skills) {
            skillCount.put(skill, skillCount.getOrDefault(skill, 0) + 1);
        }

        JFrame frame = new JFrame("Job Market Trend Visualization");
        JobTrendVisualization chart = new JobTrendVisualization(skillCount);

        frame.add(chart);
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
