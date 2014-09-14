class HomeController < ApplicationController
    require 'csv'
  def import
  end

  def new
    @home=Home.new
  end
  def index
    @home=Home.new
  end

  def search

  end
  def show_data
      #binding.pry
      python_cmd = Escape.shell_command(['python', "#{Rails.root}/public/URLGrabber.py", params[:home][:zipcode], '2014-09-14']).to_s
  system python_cmd
      #binding.pry
  end
  def read

  end
  def edit

  end
  def destroy

  end
end
