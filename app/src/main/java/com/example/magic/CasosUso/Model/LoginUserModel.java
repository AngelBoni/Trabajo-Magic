package com.example.magic.CasosUso.Model;


public class LoginUserModel implements ContractLoginUser.Model {
    private static final String IP_BASE= "http://192.168.1.9:3000/";

    @Override
    public void loginApi(User user, OnLoginUserListener onLoginUserListener) {
        ApiService apiService = RetrofitCliente.getClient(IP_BASE).create(ApiService.class);

        User loginUser = new User();
        loginUser.setEmail(user.getEmail());
        loginUser.setPassword(user.getPassword());

        Call<MyData> call = apiService.login(loginUser);

        call.enqueue(new Callback<MyData>() {
            @Override
            public void onResponse(Call<MyData> call, Response<MyData> response) {
                if (response.isSuccessful()){
                    MyData myData = response.body();
                    if (myData !=null && myData.getUser()!=null){
                        onLoginUserListener.onFinished(loginUser);
                    }
                }else {
                    onLoginUserListener.onFailure("No se encontró el usuario en la respuesta");
                }
            }

            @Override
            public void onFailure(Call<MyData> call, Throwable t) {
                handleNetWorkError(t, onLoginUserListener);
            }
        });

    }

    private void handleNetWorkError(Throwable t, OnLoginUserListener listener){
        listener.onFailure("Error de login");
    }
}