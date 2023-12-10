package book.util;

// 定义Result类，用来封装返回值
public class Result<T> {
    private boolean success; // 表示是否成功
    private String message="操作成功!"; // 表示错误信息
    private T data; // 表示返回的数据

    public Result()
    {
    }

    public Result(boolean success)
    {
        this.success = success;
    }

    public Result(boolean success, T data)
    {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }


    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }
    public Result(boolean success,String message) {
        this.success = success;
        this.message = message;
    }

    // 构造函数，根据参数设置属性值
    public Result(boolean success,String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }


}
