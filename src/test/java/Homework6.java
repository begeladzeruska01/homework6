import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class Homework6  extends ChromeRunner {
    @Test
    public  void test1() {
        WebDriverManager.chromedriver();

         Selenide.open("https://www.ee.ge/");
        $(byText("რეგისტრაცია")).click();
        $(byText("სწრაფი რეგისტრაცია")).shouldBe(Condition.visible);
        $("#singup").shouldNotBe(Condition.enabled);

        $("#firstName").setValue("ruska");
        $("#firstName").shouldNotBe(Condition.empty);

        $("#lastName").setValue("begeladze");
        $("#lastName").shouldNotBe(Condition.empty);

        $("#email").setValue("begeladzeruska@gmail.com");
        $("#email").shouldNotBe(Condition.empty);

        $("#password").setValue("ruska1234");
        $("#confirmPassword").setValue("ruska1234");

        $("#singup").shouldNotBe(Condition.disabled);

    }

      @Test
      public void test2 (){
         Selenide.refresh();
          $(byText("რეგისტრაცია")).click();
          $(byText("სწრაფი რეგისტრაცია")).shouldBe(Condition.visible);

          $("#singup").shouldBe(Condition.disabled);

          $("#firstName").click();
          $("#lastName").click();
          $("#email").click();
          $("#password").click();
          $("#confirmPassword").click();
          $("#firstName").click();
          $(byText("სახელი სავალდებულოა")).shouldBe(Condition.visible);
          $(byText("გვარი სავალდებულოა")).shouldBe(Condition.visible);
          $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
          $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);
          $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);

          $("#email").setValue("test");
          $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
          $("#email").setValue("@");
          $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
          $("#email").setValue("gmail");
          $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
          $("#email").setValue(".");
          $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);

          $("#password").setValue("ruska");
          $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);

          $("#password").setValue("1234");

          $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);
      }

      @Test
    public  void test3() {
          $(".btn-cart").click();
          $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
          $("#search_list").setValue("კომპიუტერი");

          Assert.assertEquals("კომპიუტერი", $("#search_list").getValue());

          element(".filter-select-list", 2).click();

          element(".add_to_cart", 0).click();

          $(".btn-cart").click();

//        $(byText("კალათა ცარიელია")).shouldNotBe(Condition.visible);
          Assert.assertFalse($(byText("კალათა ცარიელია")).is(Condition.visible));

          element(".fa-trash", 0).click();
          $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);

      }

      @Test
    public void test4(){
          $(".btn-cart").click();
          $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);

          $(byText("შენახული ნივთები")).click();
          $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);

          $("#search_list").setValue("კომპიუტერი");
          element(".filter-select-list", 2).click();
          element(".add_to_cart", 0).click();

          $(".btn-cart").click();
//        $(byText("კალათა ცარიელია")).shouldNotBe(Condition.visible);
          Assert.assertFalse($(byText("კალათა ცარიელია")).is(Condition.visible));
          element(".save-icon", 0).click();
          $(byText("შენახული ნივთები")).click();
//        $(byText("ვერ მოიძებნა")).shouldNotBe(Condition.visible);
          Assert.assertFalse($(byText("ვერ მოიძებნა")).is(Condition.visible));

          $(".btn-cart").click();
          $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);

          $(byText("შენახული ნივთები")).click();
          element(".cross_icon", 0).click();
          $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);

      }



      }



