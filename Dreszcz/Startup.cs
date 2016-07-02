using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Dreszcz.Startup))]
namespace Dreszcz
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
