package Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostRequest {

    Integer mode;
    Integer number1;
    Integer number2;

    public PostRequest(Integer mode, Integer number1, Integer number2)
    {
        this.mode = mode;
        this.number1 = number1;
        this.number2 = number2;
    }

    public String getParametersString() //throws BadRequestException, InternalServiceException
    {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        String parametersString;
        switch (mode) //режим работы. 0 - Узнать массу раствора, 1 - Узнать массу сухого вещества
        {
            case 0:
            {
                if (number1 ==0)
                {
                    logger.error("В данном режиме работы параметр 1 не может равняться 0!");
                }

                if (number1 <0|| number1 >100)
                {
                    logger.error("Неверное процентное содержание!");
                }
                break;
            }
            case 1:
            {
                if (number2 <0|| number2 >100)
                {
                    logger.error("Неверное процентное содержание!");
                }
                break;
            }
        }

        parametersString = number1 + " " + number2 + " " + mode;
        return parametersString;
    }

    public PostRequest() {
    }

    public int getMode() {
        return mode;
    }
    public void setMode(int work_mode) {
        this.mode = work_mode;
    }

    public int getNumber1() {
        return number1;
    }
    public void setNumber1(int value1) {
        this.number1 = value1;
    }

    public int getNumber2() {
        return number2;
    }
    public void setNumber2(int value2) {
        this.number2 = value2;
    }
}