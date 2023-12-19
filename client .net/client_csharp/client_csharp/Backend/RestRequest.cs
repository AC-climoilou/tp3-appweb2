using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Json;
using System.Text;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

using Newtonsoft.Json;

namespace client_csharp.Backend
{
    internal static class RestRequest
    {
        private static HttpClient client = new HttpClient();

        private static string API_URL = "http://localhost:300/getRoutes";

        public static async Task<Route> getRouteRESTRequest()
        {
            HttpResponseMessage reponse = await client.GetAsync(API_URL);

            Route? route = await reponse.Content.ReadFromJsonAsync<Route>();

            return route;
        }


    }
}
