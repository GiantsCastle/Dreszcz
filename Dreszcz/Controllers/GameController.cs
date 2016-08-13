using Dreszcz.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Microsoft.AspNet.Identity;
using System.Web.Mvc;
using System.Data.Entity;
using Dreszcz.Repositories;

namespace Dreszcz.Controllers
{
    [Authorize]
    public class GameController : Controller
    {
        //private ApplicationDbContext db = new ApplicationDbContext();

        private ICharactersRepository _charactersRepository;
        public GameController(ICharactersRepository charactersRepository)
        {
            _charactersRepository = charactersRepository;
        }

        // GET: Game
        public ActionResult Index(string paragraf)
        {
            var userId = User.Identity.GetUserId();
            Character postac = _charactersRepository.getCurrentCharacter(userId);

            if (postac.imie == null)
                RedirectToAction("Create");
            if (postac.paragraf != null )
                return View("paragraf" + postac.paragraf, postac);
            else
                return View(postac);
        }

        [HttpPost]
        public ActionResult Index(string paragraf, Character character)
        {
            if(ModelState.IsValid)
            {
                character.paragraf = paragraf;
                _charactersRepository.Update(character);
                return RedirectToAction("Index", paragraf);                
            }
            return View();
        }


        public ActionResult Create()
        {
            var userId = User.Identity.GetUserId();
            Character postac = _charactersRepository.getCurrentCharacter(userId);

            return View(postac);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Character postac)
        {
            if (ModelState.IsValid)
            {
                var userId = User.Identity.GetUserId();
                Character oryginal = _charactersRepository.getCurrentCharacter(userId);

                if (oryginal == null)
                {
                    return HttpNotFound();
                }

                oryginal.eliksir = postac.eliksir;
                oryginal.imie = postac.imie;
                oryginal.zrecznosc = postac.zrecznosc;
                oryginal.wytrzymalosc = postac.wytrzymalosc;
                oryginal.zrecznosc = postac.zrecznosc;
                _charactersRepository.InsertOrUpdate(oryginal);
                return RedirectToAction("Index");
            }
            else
            {
                return View(postac);
            }
        }
    }
}