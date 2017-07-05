import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;

public class TaskTest {

  @Test
  public void Task_instantiatesCorrectly_true() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(true, myTask instanceof Task);
  }

  @Test
  public void Task_instantiatesWithDescription_String() {
    Task myTask = new Task("Mow the lawn");
    assertEquals("Mow the lawn", myTask.getDescription());
  }

  @Test
  public void isCompleted_isFalseAfterInstantiation_false() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(false, myTask.isCompleted());
  }

  @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
    Task myTask = new Task("Mow the lawn");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myTask.getCreatedAt().getDayOfWeek());
  }

  @Test
  public void all_returnsAllInstancesOfTask_true() {
    Task firstTask = new Task("Mow the lawn");
    Task secondTask = new Task("Buy the groceries");
    assertEquals(true, Task.all().contains(firstTask));
    assertEquals(true, Task.all().contains(secondTask));
  }

  @Test
  public void clear_emptiesAllTaskFromArrayList_0() {
    Task myTask = new Task("Mow the lawn");
    Task.clear();
    assertEquals(0, Task.all().size());
  }

  @Test
  public void getId_tasksInstantiateWithAnId_1() {
    Task.clear(); // test will fail without this line!! We need to emptly leftover Task from previous tests.
    Task myTask = new Task("Mow the lawn");
    assertEquals(1, myTask.getId());
  }

  @Test
  public void find_returnsTaskWithSameId_secondTask() {
    Task.clear();
    Task firstTask = new Task("Mow the lawn");
    Task secondTask = new Task("Buy the groceries");
    assertEquals(Task.find(secondTask.getId()), secondTask);
  }

}
