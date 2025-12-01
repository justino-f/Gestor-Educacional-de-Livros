import { useQueryClient, useMutation } from '@tanstack/react-query';
import axios, { type AxiosPromise } from "axios"
import { type UserData } from '../interface/UserData';

const API_URL = "http://localhost:8080";

const postData = async (data : UserData): AxiosPromise<unknown> => {
  const response = axios.post(API_URL + '/v1/users', data)
  return response;
}

export function useUserData(){
  const queryClient = useQueryClient();
  const mutate = useMutation({
    mutationFn: postData,
    retry: 2,
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ['user-data'] })

    }
  })

  return mutate;
}