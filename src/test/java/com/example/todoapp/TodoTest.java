package com.example.todoapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TodoTest extends BaseTest {

    @Test(priority = 1)
    public void test1_initialEmptyList() {
        deleteAllTasks();
        List<WebElement> tasks = driver.findElements(By.cssSelector("ul#task-list li"));
        Assert.assertEquals(tasks.size(), 0, "Task list should be empty");
    }

    @Test(priority = 2)
    public void test2_addOneTask() {
        deleteAllTasks();
        addTask("Buy milk");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement task = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul#task-list li")));

        Assert.assertTrue(task.getText().contains("Buy milk"));
        WebElement checkbox = task.findElement(By.cssSelector("input[type='checkbox']"));
        Assert.assertFalse(checkbox.isSelected());

        deleteAllTasks();
    }

    @Test(priority = 3)
    public void test3_addTwoTasks() {
        deleteAllTasks();
        addTask("Buy milk");
        addTask("Walk the dog");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("ul#task-list li"), 2));

        List<WebElement> tasks = driver.findElements(By.cssSelector("ul#task-list li"));
        Assert.assertEquals(tasks.size(), 2);

        deleteAllTasks();
    }

    @Test(priority = 4)
    public void test4_deleteTask() {
        deleteAllTasks();
        addTask("Temp Task");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Delete']")));
        deleteButton.click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("ul#task-list li"), 0));
        Assert.assertEquals(driver.findElements(By.cssSelector("ul#task-list li")).size(), 0);

        deleteAllTasks();
    }

    @Test(priority = 5)
    public void test5_markTaskCompleted() {
        deleteAllTasks();
        addTask("Complete me");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']")));
        checkbox.click();

        WebElement task = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul#task-list li")));
        wait.until(ExpectedConditions.attributeContains(task, "class", "completed"));

        Assert.assertTrue(task.getAttribute("class").contains("completed"));

        deleteAllTasks();
    }

    @Test(priority = 6)
    public void test6_toggleCompletion() {
        deleteAllTasks();
        addTask("Toggle me");

        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        checkbox.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(By.cssSelector("ul#task-list li"), "class", "completed"));

        checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        checkbox.click();

        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(By.cssSelector("ul#task-list li"), "class", "completed")));

        WebElement task = driver.findElement(By.cssSelector("ul#task-list li"));
        Assert.assertFalse(task.getAttribute("class").contains("completed"));

        deleteAllTasks();
    }

    @Test(priority = 7)
    public void test7_verifyValidation() {
        deleteAllTasks();
        WebElement input = driver.findElement(By.name("task"));
        input.sendKeys("");
        input.submit();

        WebElement error = driver.findElement(By.cssSelector(".error-message"));
        Assert.assertTrue(error.isDisplayed());

        List<WebElement> tasks = driver.findElements(By.cssSelector("ul#task-list li"));
        Assert.assertEquals(tasks.size(), 0);
    }

    // ---------- Helper Methods ----------

    private void addTask(String taskName) {
        WebElement input = driver.findElement(By.name("task"));
        input.sendKeys(taskName);
        input.submit();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul#task-list li")));
    }

    private void deleteAllTasks() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        while (true) {
            List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
            if (deleteButtons.isEmpty()) break;

            WebElement button = deleteButtons.get(0);
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
            wait.until(ExpectedConditions.stalenessOf(button));
        }
    }
}
