class Home < ActiveRecord::Base
  validates :zipcode, presence: true, length: {is: 5} 
end
